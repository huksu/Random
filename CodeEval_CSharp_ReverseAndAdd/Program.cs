using System;
using System.IO;
using System.Text;

namespace ReverseAndAdd
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamReader reader = File.OpenText(args[0]))
                
                while (!reader.EndOfStream)
                {
                    string line = reader.ReadLine();
                    int iterations = 0;
                    revAndAdd(line);
                    while (!isPalindrome(line))
                    {
                        line = revAndAdd(line);
                        iterations++;
                    }

                    Console.Out.WriteLine(iterations + " " + line);
                }

        }

        static string revAndAdd(string value)
        {
            StringBuilder rev = new StringBuilder(value);
            char temp;
            for (int i = 0; i < value.Length / 2; i++)
            {
                temp = rev[rev.Length-1-i];
                rev[rev.Length-1-i] = rev[i];
                rev[i] = temp;
            }
            return addStrings(value, rev.ToString());
        }

        static string addStrings(string a, string b)
        {
            StringBuilder ret = new StringBuilder();
            int carry = 0;
            for (int i = a.Length - 1; i >= 0; i--)
            {
                int sum = (a[i] + b[i]) - (48 * 2) + carry;
                carry = sum / 10;
                ret.Insert(0, (char)((sum % 10)+48));
            }
            if (carry > 0)
            {
                ret.Insert(0, (char)(carry+48));
            }

            return ret.ToString();
        }

        static bool isPalindrome(string value)
        {
            for (int i = 0; i < value.Length / 2; i++)
            {
                if (value[i] != value[value.Length - 1 - i])
                {
                    return false;
                }
            }
            return true;
        }
        
    }
}


