public class LoanProcessingSystem {

    public static void main(String[] args) {

        int customerId = 101;
        int age = 30;
        double monthlySalary = 50000;
        double existingLoan = 5000;
        int creditScore = 750;
        String employmentType = "Salaried";
        double requestedLoan = 500000;
        int loanTenure = 5;

        double dti = (existingLoan / monthlySalary) * 100;

        double eligibleLoan = monthlySalary * 20;

        double interestRate;

        if (creditScore >= 750)
            interestRate = 8.0;
        else if (creditScore >= 650)
            interestRate = 10.0;
        else
            interestRate = 12.0;

        double r = interestRate / (12 * 100);
        int n = loanTenure * 12;

        double emi = (requestedLoan * r * Math.pow(1 + r, n))
                   / (Math.pow(1 + r, n) - 1);

        String status;

        if (age < 18 || age > 60)
            status = "Rejected - Invalid Age";
        else if (monthlySalary <= 0)
            status = "Rejected - Invalid Salary";
        else if (creditScore < 600)
            status = "Rejected - Poor Credit Score";
        else if (dti > 40)
            status = "Rejected - High Debt-to-Income Ratio";
        else if (existingLoan > monthlySalary * 10)
            status = "Rejected - Existing Loan Too High";
        else if (requestedLoan > eligibleLoan)
            status = "Rejected - Loan Amount Exceeds Eligibility";
        else
            status = "Approved";

        System.out.println("Customer ID: " + customerId);
        System.out.println("Age: " + age);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Existing Loan: " + existingLoan);
        System.out.println("Credit Score: " + creditScore);
        System.out.println("Employment Type: " + employmentType);
        System.out.println("Requested Loan: " + requestedLoan);
        System.out.println("Loan Tenure: " + loanTenure + " years");

        System.out.println("\nDebt-to-Income Ratio: " + dti + "%");
        System.out.println("Eligible Loan Amount: " + eligibleLoan);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("EMI: " + emi);
        System.out.println("Status: " + status);
    }
}
