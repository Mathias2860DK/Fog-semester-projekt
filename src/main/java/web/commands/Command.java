package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;
import web.commands.admin.*;
import web.commands.customer.CustommerComands;
import web.commands.customer.ShowCustomerOrder;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND = "404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database) {
        commands = new HashMap<>();
        //All
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("showsvgcommand", new ShowSVGCommand("designcarport"));
        commands.put("redirect", new RedirectCommand("")); //change name
        commands.put("customizecarport", new CustomizeCarportCommand("designcarport"));
        commands.put("requestbill", new GenerateRequestBillCommand("requestbill"));
        commands.put("requestreceiptpage", new SendRequestCommand("requestreceiptpage"));

        //customer
        commands.put("custommerorders", new CustommerComands("customerpage", "customer"));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("showcustomerorder", new ShowCustomerOrder("customerorder", "customer"));

        //admin
        commands.put("materialspage", new ShowMaterialsPage("materialspage", "employee"));
        commands.put("employeeorders", new GetOrdersCommand("employeepage", "employee"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("showorderdetailsadmin", new ShowOrderDetailsCommand("adminorder", "employee"));
        commands.put("showallcustomers", new ShowAllCustomers("getallcustomers", "employee"));
        commands.put("editMaterials", new ManageMaterials("manageMaterials", "employee"));
        commands.put("updatecarportprice", new UpdatePriceCommand("adminorder", "employee"));
        commands.put("sendOfferToCustomer", new SendOfferToCustomer("adminorder", "employee"));
        commands.put("showBomAdminOrder", new ShowBomAdminOrder("adminorder", "employee"));


    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db) {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null) {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
