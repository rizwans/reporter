package org.reporter.model;


public class DeleteCustomerEvent implements Event {

    private Integer customerId;

    public DeleteCustomerEvent(Integer customerId) {
        this.customerId = customerId;
    }

    public DeleteCustomerEvent() {}

    public Integer getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeleteCustomerEvent)) return false;
        DeleteCustomerEvent that = (DeleteCustomerEvent) o;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return customerId != null ? customerId.hashCode() : 0;
    }
}
