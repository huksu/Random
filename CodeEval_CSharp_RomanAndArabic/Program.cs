using System;
//using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Threading; // remove TODO

namespace RomanAndArabic
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<char,int> romans = new Dictionary<char,int>();
            romans.Add('I', 1);
            romans.Add('V', 5);
            romans.Add('X', 10);
            romans.Add('L', 50);
            romans.Add('C', 100);
            romans.Add('D', 500);
            romans.Add('M', 1000);
            
            using (StreamReader reader = File.OpenText(args[0]))
                while (!reader.EndOfStream)
                {
                    string line = reader.ReadLine();
                    if (null == line)
                        continue;
                    // do something with line
                    Console.Out.Write(line + "\n");

                    int value = 0;
                    for (int i = 0; i < line.Length / 2; i++)
                    {
                        int romanDigit = line[i * 2] - 48;
                        int multiplier = romans[line[i * 2 + 1]];
                        int sign = 1;
                        if (i < line.Length / 2 - 1)
                        {
                            sign = (romans[line[(i + 1) * 2 + 1]] > multiplier) ? -1 : 1;
                        }
                        value += sign * romanDigit * multiplier;
                        
                    }
                    Console.Out.Write(value + "\n");
                }


            Thread.Sleep(2500);
        }
    }
}

