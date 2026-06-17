package com.example.demo.model;
/**
 * ContactRequest.java
 * ─────────────────────────────────────────────────────────────
 * Plain Java class (POJO) that maps the JSON body sent by the
 * frontend contact form to a Java object.
 *
 * Spring's @RequestBody annotation uses Jackson (bundled with
 * spring-boot-starter-web) to automatically deserialize the
 * incoming JSON into this object.
 *
 * Fields must match the JSON keys sent by the frontend fetch():
 *   { "name": "...", "email": "...", "message": "..." }
 * ─────────────────────────────────────────────────────────────
 */
public class ContactRequest {

    // ── Fields ───────────────────────────────────────────────
    private String name;     // Sender's full name
    private String email;    // Sender's email address
    private String message;  // Message body

    // ── No-Arg Constructor (required by Jackson for deserialization) ──
    public ContactRequest() {}

    // ── All-Args Constructor (convenient for unit tests) ─────
    public ContactRequest(String name, String email, String message) {
        this.name    = name;
        this.email   = email;
        this.message = message;
    }

    // ── Getters ───────────────────────────────────────────────
    public String getName()    { return name; }
    public String getEmail()   { return email; }
    public String getMessage() { return message; }

    // ── Setters (required by Jackson to populate fields) ─────
    public void setName(String name)       { this.name    = name; }
    public void setEmail(String email)     { this.email   = email; }
    public void setMessage(String message) { this.message = message; }

    // ── toString (for clean console logging) ─────────────────
    @Override
    public String toString() {
        return "ContactRequest{" +
                "name='"    + name    + '\'' +
                ", email='" + email   + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
