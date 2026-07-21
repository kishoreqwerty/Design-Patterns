// Common interface implemented by both the proxy and the real object
interface Document {
    void viewDocument(String userRole);
}

// Real object that contains confidential information
class ConfidentialDocument implements Document {

    private final String documentName;

    public ConfidentialDocument(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void viewDocument(String userRole) {
        System.out.println("Opening document: " + documentName);
        System.out.println("Displaying confidential information.");
    }
}

// Proxy that controls access to the confidential document
class DocumentAccessProxy implements Document {

    private final String documentName;
    private ConfidentialDocument confidentialDocument;

    public DocumentAccessProxy(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void viewDocument(String userRole) {

        // Verify whether the user has permission
        if (isAuthorized(userRole)) {

            // Create the real object only when required
            if (confidentialDocument == null) {
                confidentialDocument =
                        new ConfidentialDocument(documentName);
            }

            System.out.println(
                    "Access granted for " + userRole + "."
            );

            confidentialDocument.viewDocument(userRole);

        } else {

            System.out.println(
                    "Access denied for " + userRole + "."
            );
        }
    }

    // Permission check
    private boolean isAuthorized(String userRole) {

        return userRole.equalsIgnoreCase("ADMIN")
                || userRole.equalsIgnoreCase("MANAGER");
    }
}

// Driver class
public class SecureDocumentProxy {

    public static void main(String[] args) {

        Document employeeRecords =
                new DocumentAccessProxy("Employee Records");

        System.out.println("Employee Login");
        employeeRecords.viewDocument("EMPLOYEE");

        System.out.println();

        System.out.println("Manager Login");
        employeeRecords.viewDocument("MANAGER");

        System.out.println();

        System.out.println("Admin Login");
        employeeRecords.viewDocument("ADMIN");
    }
}