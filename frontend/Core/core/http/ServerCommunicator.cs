using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace Core.core.http
{
    class ServerCommunicator
    {
        private readonly string WEBSERVER_URL;
        private readonly string WEBSERVER_PORT;
        private readonly string WEBSERVER_URL_EXTENSION;

        public ServerCommunicator()
        {
            WEBSERVER_URL = "http://localhost";
            WEBSERVER_PORT = ":8080";
            WEBSERVER_URL_EXTENSION = "/bored/rest";
        }

        public void Connect()
        {
            var webRequest = WebRequest.CreateHttp(
                WEBSERVER_URL
                + WEBSERVER_PORT
                + WEBSERVER_URL_EXTENSION
                + "/test"
                );
            webRequest.Method = "GET";
            var webResponse = webRequest.GetResponse();
        }
    }
}
