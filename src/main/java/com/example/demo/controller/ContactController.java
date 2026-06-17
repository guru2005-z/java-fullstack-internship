package com.example.demo.controller;

import com.example.demo.model.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactController.java
 * ─────────────────────────────────────────────────────────────
 * REST Controller that handles HTTP requests for the contact form.
 *
 * Key Annotations:
 *   @RestController  – marks this as a REST API controller;
 *                      return values are written directly to the
 *                      HTTP response body as JSON.
 *   @RequestMapping  – sets the base URL prefix for all methods.
 *   @CrossOrigin     – allows the browser to call this API even
 *                      when the HTML is served from a different
 *                      origin (needed during local development).
 * ─────────────────────────────────────────────────────────────
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")   // Allow all origins (safe for local dev)
public class ContactController {

    // ── Logger ────────────────────────────────────────────────
    // SLF4J logger – messages appear in the IntelliJ Run console
    private static final Logger logger =
            LoggerFactory.getLogger(ContactController.class);

    // ─────────────────────────────────────────────────────────
    //  POST /api/contact
    //  Accepts JSON body: { name, email, message }
    //  Prints data to console and returns a JSON success message.
    // ─────────────────────────────────────────────────────────
    @PostMapping("/contact")
    public ResponseEntity<Map<String, String>> handleContact(
            @RequestBody ContactRequest request) {

        // ── 1. Basic validation ───────────────────────────────
        if (request.getName()    == null || request.getName().isBlank() ||
                request.getEmail()   == null || request.getEmail().isBlank() ||
                request.getMessage() == null || request.getMessage().isBlank()) {

            Map<String, String> error = new HashMap<>();
            error.put("status",  "error");
            error.put("message", "All fields are required.");
            return ResponseEntity.badRequest().body(error);
        }

        // ── 2. Print to console (the main task requirement) ───
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║      📬 New Contact Form Submission    ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  Name    : " + request.getName());
        System.out.println("║  Email   : " + request.getEmail());
        System.out.println("║  Message : " + request.getMessage());
        System.out.println("╚══════════════════════════════════════╝\n");

        // ── 3. Also log via SLF4J (appears in structured logs) ─
        logger.info("Contact form received — Name: '{}', Email: '{}', Message: '{}'",
                request.getName(),
                request.getEmail(),
                request.getMessage());

        // ── 4. Build and return a JSON success response ───────
        Map<String, String> response = new HashMap<>();
        response.put("status",  "success");
        response.put("message", "Thank you, " + request.getName() +
                "! Your message has been received.");

        // HTTP 200 OK with JSON body
        return ResponseEntity.ok(response);
    }

    // ─────────────────────────────────────────────────────────
    //  GET /api/health  – simple health-check endpoint
    //  Useful to verify the server is running before testing.
    // ─────────────────────────────────────────────────────────
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Contact Form API");
        return ResponseEntity.ok(response);
    }
}
