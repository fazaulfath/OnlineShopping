// Program to test AdminService class
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class contains unit tests for the AdminService class,
// including methods to test adding, retrieving, and removing admins.

package com.tnsif.onlineshopping.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tnsif.onlineshopping.entities.Admin;
import com.tnsif.onlineshopping.services.AdminService;

public class AdminServiceTest {

    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        adminService = new AdminService();
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin(1, "adminUser", "admin@example.com");
        adminService.addAdmin(admin);
        assertNotNull(adminService.getAdminById(1));
    }

    @Test
    public void testGetAdminById() {
        Admin admin = new Admin(2, "adminUser2", "admin2@example.com");
        adminService.addAdmin(admin);
        Admin retrievedAdmin = adminService.getAdminById(2);
        assertEquals("adminUser2", retrievedAdmin.getUsername());
        assertEquals("admin2@example.com", retrievedAdmin.getEmail());
    }

    @Test
    public void testRemoveAdmin() {
        Admin admin = new Admin(3, "adminUser3", "admin3@example.com");
        adminService.addAdmin(admin);
        boolean removed = adminService.removeAdmin(3);
        assertTrue(removed);
        assertNull(adminService.getAdminById(3));
    }

    @Test
    public void testGetAdmins() {
        Admin admin1 = new Admin(4, "adminUser4", "admin4@example.com");
        Admin admin2 = new Admin(5, "adminUser5", "admin5@example.com");
        adminService.addAdmin(admin1);
        adminService.addAdmin(admin2);
        assertEquals(2, adminService.getAdmins().size());
    }
}
