package edu.miu.camsapp.constant;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
public class ResourceKeyConstant {

    public static final  String CUSTOMER_ACCOUNTS = "/list";
    public interface CustomerAccountRestResource{
        String CUSTOMER_ACCOUNT_REST_RESOURCE = "spebank/api/account";
        String PRIME_ACCOUNTS = "/prime/list";
    }

    public interface CustomerAccountMVCResource{
        String CUSTOMER_ACCOUNT_RESOURCE = "/spebank/account";
    }
}
