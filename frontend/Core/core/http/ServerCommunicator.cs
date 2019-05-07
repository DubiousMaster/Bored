using Core.core.models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;

namespace Core.core.http
{
    class ServerCommunicator
    {
        private readonly string WEBSERVER_URL;
        private readonly string WEBSERVER_PORT;
        private readonly string WEBSERVER_URL_EXTENSION;
        private string WEBSERVER_FULL_URL;

        public ServerCommunicator()
        {
            WEBSERVER_URL = "http://localhost";
            WEBSERVER_PORT = ":8080";
            WEBSERVER_URL_EXTENSION = "/bored/rest";
            WEBSERVER_FULL_URL = WEBSERVER_URL + WEBSERVER_PORT + WEBSERVER_URL_EXTENSION;
        }

        public WebResponse GetRequest(string path)
        {
            var webRequest = WebRequest.CreateHttp(
                WEBSERVER_FULL_URL + path
                );
            webRequest.Method = "GET";
            return webRequest.GetResponse();
        }

        public async Task<WebResponse> PostRequestAsync(string path, string objects)
        {
            var webRequest = WebRequest.CreateHttp(
                WEBSERVER_FULL_URL + path
                );
            webRequest.Method = "POST";
            webRequest.ContentType = "application/json";
            var dataStream = await webRequest.GetRequestStreamAsync();
            var bytes = Encoding.UTF8.GetBytes(objects);
            await dataStream.WriteAsync(bytes, 0, bytes.Length);
            dataStream.Close();
            return webRequest.GetResponse();
        }
    }
}
