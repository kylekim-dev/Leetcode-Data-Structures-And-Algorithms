using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Logging
{
    public class Log
    {
        public enum LogLevel
        {
            Error,
            Warning,
            Info,
            Debug
        }

        public Log(LogLevel logType, DateTime logTime, string logMessage)
        {
            this.LogType = logType;
            this.LogTime = logTime;
            this.LogMessage = logMessage;
        }

        protected LogLevel LogType { get; set; }
        protected DateTime LogTime { get; set; }
        protected string LogMessage { get; set; }
    }
}
