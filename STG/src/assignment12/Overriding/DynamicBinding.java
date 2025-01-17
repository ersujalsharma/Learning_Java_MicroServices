package assignment12.Overriding;

class DynamicBinding {

    public static void main(String[] args) {
        RegularCustomer regCust1 = new RegularCustomer();
        RegularCustomer regCust2 = new RegularCustomer();
        PremiumCustomer premCust1 = new PremiumCustomer();

        showCustomerDetails(regCust1);
        showCustomerDetails(premCust1);
        showCustomerDetails(regCust2);
    }

    public static void showCustomerDetails(Customer customer) {
        customer.display();
    }
}

class Customer {
    public void display() {
        System.out.println("Customer is coming...");
    }
}

class RegularCustomer extends Customer {
    @Override
    public void display() {
        System.out.println("A regular customer has come");
    }
}

class PremiumCustomer extends Customer {
    @Override
    public void display() {
        System.out.println("A premium customer has come");
    }
}

