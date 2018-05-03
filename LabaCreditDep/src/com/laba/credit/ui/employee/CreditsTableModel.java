package com.laba.credit.ui.employee;

import com.laba.credit.ServiceLocator;
import com.laba.credit.credit.CreditRequest;
import com.laba.credit.credit.CreditService;

import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.util.List;

public class CreditsTableModel extends DefaultTableModel {
    private CreditService creditService = ServiceLocator.getInstance().getCreditService();

    private List<CreditRequest> requests;

    public CreditsTableModel(List<CreditRequest> requests) {
        super(requests.size(), 5);
        this.requests = requests;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "client name";
            case 1:
                return "credit sum";
            case 2:
                return "credit currency";
            case 3:
                return "submit date";
            case 4:
                return "status";
            default:
                throw new IllegalArgumentException("Unknown column: " + column);
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        CreditRequest request = requests.get(row);

        switch (column) {
            case 0:
                return request.getClientId(); //todo: obtain client name and show it
            case 1:
                return request.getSum();
            case 2:
                return request.getCurrency();
            case 3:
                return DateFormat.getInstance().format(request.getSubmitDate());
            case 4:
                return creditService.getStatus(request.getId());
            default:
                throw new IllegalArgumentException("Unknown column: " + column);
        }
    }
}
