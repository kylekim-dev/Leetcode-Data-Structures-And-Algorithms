using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Logging
{
    public class WriteToJSON : Log, ILogger
    {
        public WriteToJSON(LogLevel logType, DateTime logTime, string logMessage) : base(logType, logTime, logMessage)
        {

        }

        public void SaveLog()
        {
            Console.WriteLine("Save To JSON: {0}", LogType);
        }
    }
}
