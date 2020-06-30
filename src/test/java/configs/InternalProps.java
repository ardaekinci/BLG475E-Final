package configs;

public class InternalProps extends AbstractProps
{
    private String phoneNumber;


    public InternalProps()
    {
        loadConfigProperties("internal_config.properties");

        this.phoneNumber = configProps.getProperty("user.phoneNumber");
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}
