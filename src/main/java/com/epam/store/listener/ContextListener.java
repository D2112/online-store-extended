package com.epam.store.listener;

/**
 * The initializer of the application, on initialization of the context
 * creates all classes in one exemplar that need to be available through
 * whole application. Also on initializing class looks is database empty,
 * if it is, then database will be deployed from sql script.
 * On destroying of the context it'll shutdown the connection pool.
 */

/*
public class ContextListener implements ServletContextListener {
    public static final String CATEGORY_LIST_ATTRIBUTE_NAME = "categories";
    private static final Logger log = LoggerFactory.getLogger(ContextListener.class);
    private static final String SETTINGS_CLASS = "com.epam.store.config.ApplicationSettings";
    private static final String SCRIPT_FILE_NAME = "online-store.sql";
    private static final String TABLE_COUNT_QUERY = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC';";
    private ConnectionPool connectionPool;

    @Override
    public void contextInitialized(ServletContextEvent arg) {
        initializeSettings();
        ServletContext servletContext = arg.getServletContext();
        connectionPool = new SqlConnectionPool();
        try (SqlPooledConnection connection = connectionPool.getConnection()) {
            if (isDatabaseEmpty(connection)) {
                log.info("Database is empty. Trying to deploy with script");
                deployDatabaseFromScript(connection);
                log.info("Script deployed successfully");
            }
        } catch (SQLException | IOException e) {
            throw new ApplicationInitializationException(e);
        }
        DaoFactory daoFactory = new JdbcDaoFactory(connectionPool);
        servletContext.setAttribute("daoFactory", daoFactory);

        //set services to servlet context, the class name is used as an attribute name
        //set categories list to application context to have access to it from everywhere
    }

    private void initializeSettings() {
        try {
            Class.forName(SETTINGS_CLASS);
        } catch (ClassNotFoundException e) {
            throw new ApplicationInitializationException(e);
        }
    }

    private String getNameForService(Class clazz) {
        return clazz.getSimpleName();
    }

    private boolean isDatabaseEmpty(SqlPooledConnection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(TABLE_COUNT_QUERY);
        rs.next();
        long count = rs.getLong(1);
        return count == 0;
    }

    private void deployDatabaseFromScript(SqlPooledConnection connection) throws IOException, SQLException {
        String scriptQuery = readScriptQuery();
        Statement statement = connection.createStatement();
        statement.execute(scriptQuery);
        statement.close();
    }

    private String readScriptQuery() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = ContextListener.class.getClassLoader().getResourceAsStream(SCRIPT_FILE_NAME)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg) {
        connectionPool.shutdown();
    }
}*/
