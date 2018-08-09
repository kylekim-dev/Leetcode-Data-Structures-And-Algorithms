using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Logging;

namespace PG3_Logger
{
    class Program
    {
        static void Main(string[] args)
        {
            Run();
        }

        static void Run()
        {
            ILogger Department_A = new WriteToDB(Log.LogLevel.Debug, DateTime.Now, "");
            ILogger Department_B = new WriteToCVS(Log.LogLevel.Warning, DateTime.Now, "");
            ILogger Department_C = new WriteToJSON(Log.LogLevel.Info, DateTime.Now, "");

            ShowList(Department_A, Department_B, Department_C);
            Console.WriteLine("-------------------------------");

            Department_B = new WriteToDB(Log.LogLevel.Warning, DateTime.Now, "");
            ShowList(Department_A, Department_B, Department_C);
        }

        static public void ShowList(params ILogger[] list)
        {
            foreach (var l in list)
            {
                l.SaveLog();
                Console.WriteLine();
            }
        }
    }
}
