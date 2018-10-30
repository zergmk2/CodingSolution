import java.util.*;

Class Solution
{
    public boolean isUnique(String str)
    {
        // ASCII
        if (str.length() > 128) 
            return false;

        boolean[] exists = new boolean[128];

        for(int i = 0; i < str.length(); i++)
        {
            int ch = str.charAt(i);
            if (exists[ch])
            {
                return false;
            }
            else
            {
                exists[ch] = true;
            }
        }
        return true;    
    }
}