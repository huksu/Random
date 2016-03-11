using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeEval
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = args[0];
            string line;
            
            System.IO.StreamReader file = new System.IO.StreamReader(path);
            while ((line = file.ReadLine()) != null)
            {
                int matchCount = 0;
                string[] rows = line.Replace(" ", "").Split('|');
                
                for (int i = 0; i < rows.Length - 1; i++)
                {
                    for (int j = 0; j < rows[i].Length - 1; j++)
                    {
                        // build the substring
                        string substring = string.Concat(rows[i][j], rows[i][j + 1], rows[i + 1][j], rows[i + 1][j + 1]);

                        // sort the substring
                        substring = String.Concat(substring.OrderBy(c => c));

                        // check for a match
                        if (substring == "cdeo")
                        {
                            matchCount++;
                        }
                    }
                }

                Console.WriteLine(matchCount);
            }
            file.Close();
        }
    }
}
