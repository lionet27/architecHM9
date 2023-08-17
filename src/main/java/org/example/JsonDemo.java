package org.example;//package org.example;
//// Импортируем необходимые классы для работы с HTTP-сервером
//        import com.sun.net.httpserver.HttpHandler;
//        import com.sun.net.httpserver.HttpServer;
//        import com.sun.net.httpserver.HttpExchange;
//
//        import java.io.IOException;
//        import java.io.OutputStream;
//        import java.net.InetSocketAddress;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.concurrent.atomic.AtomicInteger;
//
//public class Main {
//
//    // Эмулируем базу данных с использованием списка в памяти.
//    private static List<User> users = new ArrayList<>();
//    private static AtomicInteger idGenerator = new AtomicInteger(1); // Генератор ID для пользователей.
//
//    public static void main(String[] args) throws IOException {
//        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
//        server.createContext("/users", new UsersHandler());
//        server.start();
//        System.out.println("Server started on port 8080");
//    }
//
//    static class UsersHandler implements HttpHandler {
//        @Override
//        public void handle(HttpExchange exchange) throws IOException {
//            if ("GET".equals(exchange.getRequestMethod())) {
//                // Возвращаем список всех пользователей.
//                String responseBody = users.toString();
//                exchange.sendResponseHeaders(200, responseBody.length());
//                try (OutputStream os = exchange.getResponseBody()) {
//                    os.write(responseBody.getBytes());
//                }
//            } else if ("POST".equals(exchange.getRequestMethod())) {
//                // Добавляем нового пользователя.
//                int newId = idGenerator.getAndIncrement();
//                User newUser = new User(newId, "User" + newId);
//                users.add(newUser);
//                String responseBody = "User added: " + newUser;
//                exchange.sendResponseHeaders(201, responseBody.length());
//                try (OutputStream os = exchange.getResponseBody()) {
//                    os.write(responseBody.getBytes());
//                }
//            } else if ("DELETE".equals(exchange.getRequestMethod())) {
//                // Удаляем пользователя по ID.
//                String[] pathParts = exchange.getRequestURI().getPath().split("/");
//                if (pathParts.length == 3) {
//                    int userId = Integer.parseInt(pathParts[2]);
//                    users.removeIf(user -> user.getId() == userId);
//                    String responseBody = "User with ID " + userId + " removed.";
//                    exchange.sendResponseHeaders(200, responseBody.length());
//                    try (OutputStream os = exchange.getResponseBody()) {
//                        os.write(responseBody.getBytes());
//                    }
//                }
//            } else {
//                String responseBody = "Method not allowed";
//                exchange.sendResponseHeaders(405, responseBody.length());
//                try (OutputStream os = exchange.getResponseBody()) {
//                    os.write(responseBody.getBytes());
//                }
//            }
//        }
//    }
//
//    static class User {
//        private int id;
//        private String name;
//
//        public User(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "id=" + id +
//                    ", name='" + name + '\'' +
//                    '}';
//        }
//    }
//}
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//class Book {
//    private String title;
//    private String author;
//    private int year;
//
//    // Конструктор по умолчанию, необходим для Jackson
//    public Book() {}
//
//    public Book(String title, String author, int year) {
//        this.title = title;
//        this.author = author;
//        this.year = year;
//    }
//
//    // Геттеры и сеттеры
//    public String getTitle() { return title; }
//    public void setTitle(String title) { this.title = title; }
//    public String getAuthor() { return author; }
//    public void setAuthor(String author) { this.author = author; }
//    public int getYear() { return year; }
//    public void setYear(int year) { this.year = year; }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", year=" + year +
//                '}';
//    }
//}
//public class JsonDemo {
//    public static void main(String[] args) throws Exception {
//        // Создаем объект ObjectMapper для преобразования между объектами Java и JSON
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // 1. Создаем новый объект Book
//        Book book = new Book("1984", "George Orwell", 1949);
//
//        // 2. Сериализуем объект Book в строку JSON
//        String jsonString = objectMapper.writeValueAsString(book);
//        System.out.println("Serialized JSON: " + jsonString);
//
//        // 3. Десериализуем строку JSON обратно в объект Book
//        Book deserializedBook = objectMapper.readValue(jsonString, Book.class);
//        System.out.println("Deserialized Object: " + deserializedBook);
//    }
//}


//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class JsonDemo {
//
//    public static void main(String[] args) throws Exception {
//        // Создаем объект ObjectMapper для работы с JSON
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Создаем новый объект Book
//        Book book = new Book("1984", "George Orwell", 1949);
//
//        // Сериализуем объект Book в строку JSON
//        String jsonString = objectMapper.writeValueAsString(book);
//        System.out.println("Serialized JSON: " + jsonString);
//
//        // Сохраняем JSON строку в файл
//        Files.write(Paths.get("book.json"), jsonString.getBytes());
//
//        // Чтение JSON строки из файла
//        String readJson = new String(Files.readAllBytes(Paths.get("book.json")));
//
//        // Десериализация JSON строки из файла обратно в объект
//        Book deserializedBook = objectMapper.readValue(readJson, Book.class);
//        System.out.println("Deserialized Object from File: " + deserializedBook);
//    }
//
//    public static class Book {
//        private String title;
//        private String author;
//        private int year;
//
//        // Пустой конструктор необходим для Jackson
//        public Book() {}
//
//        public Book(String title, String author, int year) {
//            this.title = title;
//            this.author = author;
//            this.year = year;
//        }
//
//        // Геттеры и сеттеры
//
//        public String getTitle() { return title; }
//        public void setTitle(String title) { this.title = title; }
//
//        public String getAuthor() { return author; }
//        public void setAuthor(String author) { this.author = author; }
//
//        public int getYear() { return year; }
//        public void setYear(int year) { this.year = year; }
//
//        @Override
//        public String toString() {
//            return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
//        }
//    }
//}

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class JsonDemo {

    private static List<User> users = new ArrayList<>();
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private static ObjectMapper objectMapper = new ObjectMapper(); // Создаем объект ObjectMapper

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/users", new UsersHandler());
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String responseBody = objectMapper.writeValueAsString(users);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                int newId = idGenerator.getAndIncrement();
                User newUser = new User(newId, "User" + newId);
                users.add(newUser);
                String responseBody = objectMapper.writeValueAsString(newUser);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(201, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3) {
                    int userId = Integer.parseInt(pathParts[2]);
                    users.removeIf(user -> user.getId() == userId);
                    String responseBody = "{\"message\":\"User with ID " + userId + " removed.\"}";
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, responseBody.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            } else {
                String responseBody = "{\"error\":\"Method not allowed\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(405, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}