package com.epam.store.web;

import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Response {
    private Status status;
    private List<String> messages;
    private MessageSource messageSource;
    private Locale locale;

    public Response(MessageSource messageSource, Locale locale) {
        messages = new ArrayList<>();
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addMessageByKey(String key) {
        messages.add(messageSource.getMessage(key, null, locale));
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addErrorMessages(Errors errors) {
        for (ObjectError error : errors.getAllErrors()) {
            messages.add(messageSource.getMessage(error, locale));
        }
    }

    public enum Status {
        SUCCESS, FAIL
    }
}
