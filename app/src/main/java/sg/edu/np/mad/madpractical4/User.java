package sg.edu.np.mad.madpractical4;

public class User {
    private String name;
    private String description;
    private int id;
    private boolean followed;

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }

    public void setDescription(String d)
    {
        description = d;
    }
    public String getDescription()
    {
        return description;
    }

    public void setId(int i)
    {
        id = i;
    }
    public int getId()
    {
        return id;
    }

    public void setFollowed(boolean f)
    {
        followed = f;
    }
    public boolean getFollowed()
    {
        return followed;
    }

    public User(String n, String d, int i, boolean f)
    {
        name = n;
        description = d;
        id = i;
        followed = f;
    }
}
