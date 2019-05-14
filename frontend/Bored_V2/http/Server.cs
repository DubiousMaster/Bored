using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Bored_V2.http
{
    internal abstract class Server
    {
        private readonly string WEBSERVER_URL;
        private readonly string WEBSERVER_PORT;
        private readonly string WEBSERVER_URL_EXTENSION;

        public string WEBSERVER_FULL_URL
        {
            get
            {
                return WEBSERVER_URL + WEBSERVER_PORT + WEBSERVER_URL_EXTENSION;
            }
        }

        protected Server(string url, string port, string extension)
        {
            WEBSERVER_URL = url;
            WEBSERVER_PORT = port;
            WEBSERVER_URL_EXTENSION = extension;
        }
    }
}
