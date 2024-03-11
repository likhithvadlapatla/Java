public class DHL implements DeliveryService{

    @Override
    public Boolean deliveryProduct(Double amount) {
        System.out.println("Product delivered with DHL service and amount paid is : "+ amount);
        return true;
    }
}
