package controller;

import dao.InvoiceDAO;
import model.Invoice;

public class InvoiceController {
    private InvoiceDAO invoiceDAO;

    public InvoiceController() {
        this.invoiceDAO = new InvoiceDAO();
    }

    public Invoice getInvoice(int userId, int bookingId) {
        try {
            return invoiceDAO.getInvoiceData(userId, bookingId);
        } catch (Exception e) {
            // Log the error and return null or throw a custom exception
            System.err.println("Error getting invoice: " + e.getMessage());
            return null;
        }
    }
}