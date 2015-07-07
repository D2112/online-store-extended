package com.epam.store;

import com.epam.store.model.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class Images {

    public static byte[] resize(byte[] data, int width, int height) throws IOException {
        BufferedImage img;
        try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
            img = ImageIO.read(in);
        }
        java.awt.Image scaledImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            ImageIO.write(imageBuff, "jpg", buffer);
            return buffer.toByteArray();
        }
    }

    public static Image resize(Image image) throws IOException {
        byte[] resizedBytes = resize(image.getContent(), Image.STANDARD_WIDTH, Image.STANDARD_HEIGHT);
        return new Image(image.getName(), image.getContentType(), resizedBytes);
    }
}
