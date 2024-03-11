public class FedEx implements DeliveryService{

    @Override
    public Boolean deliveryProduct(Double amount) {
        System.out.println("Product delivered with FedEx service and amount paid is : "+ amount);
        return true;
    }
}
