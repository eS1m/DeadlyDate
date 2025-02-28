public final class userNameSingleton
{
    private static volatile userNameSingleton instance = null;
    private String name;

    private userNameSingleton()
    {
        name = " ";
    }

    public static userNameSingleton getInstance()
    {
        if (instance == null){
            synchronized(userNameSingleton.class)   
            {
                if (instance == null) {
                    instance = new userNameSingleton();
                }
            }
        }
        return instance;
    }

    public void setName(String input)
    {
        name = input;
    }

    public String getName()
    {
        return name;
    }
}