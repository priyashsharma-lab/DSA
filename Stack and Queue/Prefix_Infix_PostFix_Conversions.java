import java.util.Stack;
public class Prefix_Infix_PostFix_Conversions 
{
    public static int precedence(char c)
    {
        if (c=='^')
        {
            return 3;
        }
        else if (c=='*' || c=='/')
        {
            return 2;
        }
        else if (c=='+' || c=='-')
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    public static String infixToPostfix(String infix)
    {
        Stack<Character> st=new Stack<>();
        String postfix="";
        for (int i=0;i<infix.length();i++)
        {
            char c=infix.charAt(i);
            if (c=='(')
            {
                st.push(c);
            }
            else if (c==')')
            {
                while (!st.empty())
                {
                    char t=st.pop();
                    if (t=='(')
                    {
                        break;
                    }
                    postfix+=t;
                }
            }
            else if (c=='^' || c=='*' || c=='/' || c=='+' || c=='-')
            {
                while (!st.empty() && st.peek()!='(' && (precedence(c)<precedence(st.peek()) || (precedence(c)==precedence(st.peek()) && c!='^')))
                {
                    char t=st.pop();
                    postfix+=t;
                }
                st.push(c);
            }
            else
            {
                postfix+=c;
            }
        }
        while (!st.empty())
        {
            char t=st.pop();
            postfix+=t;
        }
        return postfix;
    }    
    public static String infixToPrefix(String infix)
    {
        String prefiX="";
        String revInfix="";
        for (int i=infix.length()-1;i>=0;i--)
        {
            char c=infix.charAt(i);
            if (c=='(')
            {
                revInfix+=')';
            }
            else if (c==')')
            {
                revInfix+='(';
            }
            else
            {
                revInfix+=c;
            }
        }
        Stack<Character> st = new Stack<>();
        String postfix = "";

        for (int i = 0; i < revInfix.length(); i++)
        {
            char c = revInfix.charAt(i);

            if (Character.isLetterOrDigit(c))
            {
                postfix += c;
            }
            else if (c == '(')
            {
                st.push(c);
            }
            else if (c == ')')
            {
                while (!st.empty() && st.peek() != '(')
                {
                    postfix += st.pop();
                }
                st.pop();
            }
            else
            {
                while (!st.empty() &&
                       st.peek() != '(' &&
                       (precedence(c) < precedence(st.peek()) ||
                       (precedence(c) == precedence(st.peek()) && c == '^')))
                {
                    postfix += st.pop();
                }

                st.push(c);
            }
        }

        while (!st.empty())
        {
            postfix += st.pop();
        }
        for (int i=postfix.length()-1;i>=0;i--)
        {
            prefiX+=postfix.charAt(i);
        }
        return prefiX;
    }
    public static String postfixToInfix(String postfix)
    {
        String infix;
        Stack<String> st=new Stack<>();
        for (int i=0;i<postfix.length();i++)
        {
            char c=postfix.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String r=st.pop();
                String l=st.pop();
                String newExp="("+l+c+r+")";
                st.push(newExp);
            }
        }
        infix=st.pop();
        return infix;
    }
    public static String prefixToInfix(String prefix)
    {
        String infix;
        Stack<String> st=new Stack<>();
        for (int i=prefix.length()-1;i>=0;i--)
        {
            char c=prefix.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String l=st.pop();
                String r=st.pop();
                String newExp="("+l+c+r+")";
                st.push(newExp);
            }
        }
        infix=st.pop();
        return infix;
    }
    public static String postfixToPrefix(String postfix)
    {
        String prefix;
        Stack<String> st=new Stack<>();
        for (int i=0;i<postfix.length();i++)
        {
            char c=postfix.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String r=st.pop();
                String l=st.pop();
                String newExp=c+l+r;
                st.push(newExp);
            }
        }
        prefix=st.pop();
        return prefix;
    }
    public static String prefixToPostfix(String prefix)
    {
        String postfix;
        Stack<String> st=new Stack<>();
        for (int i=prefix.length()-1;i>=0;i--)
        {
            char c=prefix.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String l=st.pop();
                String r=st.pop();
                String newExp=l+r+c;
                st.push(newExp);
            }
        }
        postfix=st.pop();
        return postfix;
    }
    public static void main(String[] args) 
    {
        // String infix="a+b*(c^d-e)";
        String infix="(A+B)*C-D+F";
        // String infix="a^b^c";
        String postfix="AB+C*";
        String prefix="*+ABC";
        System.out.println(infixToPostfix(infix));    
        System.out.println(infixToPrefix(infix));
        System.out.println(postfixToInfix(postfix));
        System.out.println(prefixToInfix(prefix));
        System.out.println(postfixToPrefix(postfix));
        System.out.println(prefixToPostfix(prefix));
    }
}
