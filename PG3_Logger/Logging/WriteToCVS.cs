using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Logging
{
    public class WriteToCVS : Log, ILogger
    {
        public WriteToCVS(LogLevel logType, DateTime logTime, string logMessage) : base(logType, logTime, logMessage)
        {

        }

        public void SaveLog()
        {
            Console.WriteLine("Save To CVS: {0}", LogType);
        }
    }
}
