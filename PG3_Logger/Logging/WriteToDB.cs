using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Logging
{
    public class WriteToDB : Log, ILogger
    {
        public WriteToDB(LogLevel logType, DateTime logTime, string logMessage) : base(logType, logTime, logMessage)
        {

        }

        public void SaveLog()
        {
            Console.WriteLine("Save To DB: {0}", LogType);
        }
    }
}
