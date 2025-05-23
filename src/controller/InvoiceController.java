package controller;

import dao.InvoiceDAO;
import model.Invoice;

public class InvoiceController {
    private InvoiceDAO invoiceDAO;

    public InvoiceController() {
        this.invoiceDAO = new InvoiceDAO();
    }

    public Invoice getInvoice(int userId, int bookedId) {
        return invoiceDAO.getInvoiceData(userId, bookedId);
    }
}