using System;
using System.IO;
using System.Collections.Generic;
//using System.Threading;  // TODO remove

namespace ValidParentheses
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamReader reader = File.OpenText(args[0]))
            while (!reader.EndOfStream)
            {
                string line = reader.ReadLine();
                if (null == line)
                    continue;

                    //Console.Out.WriteLine(line);
                    Console.Out.WriteLine(isValid(line) ? "True" : "False");
            }

            //Thread.Sleep(10000);
        }

        static bool isValid(string line)
        {
            Stack<char> myStack = new Stack<char>();
            for (int i = 0; i < line.Length; i++)
            {
                if (line[i] == '(' || line[i] == '{' || line[i] == '[')
                {
                    // push
                    myStack.Push(line[i]);
                }
                else
                {
                    // try pop
                    if (myStack.Count <= 0)
                    {
                        return false;
                    }
                    else
                    {
                        char popped = myStack.Pop();
                        //Console.Out.WriteLine("pop " + popped + " line[i] " + line[i]);
                        if (popped != line[i] - 2 && popped != line[i] - 1)
                        {
                            // the specified characters must be within 
                            // two of each other in the ascii table
                            return false;
                        }
                    }
                }
            }
            return myStack.Count == 0 ? true : false;
        }
    }
}

