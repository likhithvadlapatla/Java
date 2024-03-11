public class FedEx implements DeliveryService{

    static{
        System.out.println("FedEx class is loaded.");
    }

    FedEx(){
        System.out.println("FedEx bean is created.");
    }

    @Override
    public Boolean deliverProduct(Double amount) {
        System.out.println("Product delivered through FedEx and amount paid is : "+amount);
        return true;
    }
}
