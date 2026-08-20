public class OrderManagement {
    public static void main(String[] args) {

        int productID1 = 101;
        String category1 = "Electronics";
        int quantity1 = 2;
        double price1 = 10000;
        double discount1 = 10;

        int productID2 = 102;
        String category2 = "Clothing";
        int quantity2 = 3;
        double price2 = 2000;
        double discount2 = 20;

        boolean product1Available = true;
        boolean product2Available = true;

        String coupon = "SAVE10";

        double gst = 18;

        double subtotal1 = quantity1 * price1;
        double subtotal2 = quantity2 * price2;

        double categoryDiscount1 = subtotal1 * discount1 / 100;
        double categoryDiscount2 = subtotal2 * discount2 / 100;

        double total = subtotal1 - categoryDiscount1
                     + subtotal2 - categoryDiscount2;

        double couponDiscount = 0;

        switch (coupon) {
            case "SAVE10":
                couponDiscount = total * 10 / 100;
                break;
            case "SAVE20":
                couponDiscount = total * 20 / 100;
                break;
            case "NOCOUPON":
                couponDiscount = 0;
                break;
            default:
                System.out.println("Invalid Coupon Code");
        }

        if (couponDiscount > 5000) {
            couponDiscount = 5000;
        }

        double discountedAmount = total - couponDiscount;

        double tax = discountedAmount * gst / 100;

        double shipping;

        if (discountedAmount >= 5000) {
            shipping = 0;
        }
        else {
            shipping = 100;
        }

        int totalQuantity = quantity1 + quantity2;

        if (totalQuantity >= 10) {
            double bulkDiscount = discountedAmount * 5 / 100;
            discountedAmount = discountedAmount - bulkDiscount;
        }

        double finalAmount = discountedAmount + tax + shipping;

        System.out.println("----- E-COMMERCE ORDER -----");

        System.out.println("\nProduct 1");
        System.out.println("Product ID: " + productID1);
        System.out.println("Category: " + category1);
        System.out.println("Quantity: " + quantity1);
        System.out.println("Unit Price: Rs." + price1);
        System.out.println("Subtotal: Rs." + subtotal1);
        System.out.println("Discount: Rs." + categoryDiscount1);

        System.out.println("\nProduct 2");
        System.out.println("Product ID: " + productID2);
        System.out.println("Category: " + category2);
        System.out.println("Quantity: " + quantity2);
        System.out.println("Unit Price: Rs." + price2);
        System.out.println("Subtotal: Rs." + subtotal2);
        System.out.println("Discount: Rs." + categoryDiscount2);

        System.out.println("\nTotal before coupon: Rs." + total);
        System.out.println("Coupon discount: Rs." + couponDiscount);
        System.out.println("GST: Rs." + tax);
        System.out.println("Shipping: Rs." + shipping);
        System.out.println("Final Amount: Rs." + finalAmount);

        if (quantity1 <= 0 || quantity2 <= 0) {
            System.out.println("\nInvalid Quantity");
        }

        if (quantity1 < 0 || quantity2 < 0) {
            System.out.println("Negative Quantity Not Allowed");
        }

        if (!product1Available || !product2Available) {
            System.out.println("Out-of-stock Product");
        }

        if (totalQuantity >= 10) {
            System.out.println("Bulk Order Discount Applied");
        }

        if (shipping == 0) {
            System.out.println("Free Shipping Applied");
        }

        System.out.println("\nOrder Processing Completed.");
    }
}

