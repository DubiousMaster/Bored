using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Bored_V2.http.requests
{
    internal class Request
    {
        private readonly Server server;

        protected Request(Server server)
        {
            this.server = server;
        }

        protected HttpClient CreateClient()
        {
            var httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(server.WEBSERVER_FULL_URL);
            httpClient.DefaultRequestHeaders.Accept.Clear();
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            return httpClient;
        }

        protected string GetJsonResponse(HttpResponseMessage responseMessage)
        {
            var result = responseMessage.Content.ReadAsByteArrayAsync().Result;
            return Encoding.UTF8.GetString(result);
        }

        protected async Task<HttpResponseMessage> GetRequest(string path)
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var response = await httpClient.GetAsync(server.WEBSERVER_FULL_URL + path);
                    return response;
                }
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            catch (HttpRequestException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            return null;
        }

        protected async Task<HttpResponseMessage> PostRequest(string path, object postObject)
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var json = JsonConvert.SerializeObject(postObject);
                    Console.WriteLine("Serialized object: " + postObject + " to: " + json);
                    var httpContent = new ByteArrayContent(Encoding.UTF8.GetBytes(json));
                    var headers = httpContent.Headers;
                    headers.Add("content-type", "application/json");
                    
                    foreach(var header in headers)
                    {
                        Console.WriteLine("Request contains header [" + header.Key + "] with value: [" + header.Value + "].");
                    }
                    var response = await httpClient.PostAsync(server.WEBSERVER_FULL_URL + path, httpContent);
                    Console.WriteLine("Server responded with status message: " + response.StatusCode);
                    return response;
                }
            }
            catch(ArgumentNullException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            catch(HttpRequestException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            return null;
        }

        protected async Task<HttpResponseMessage> PutRequest(string path, object putObject)
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var json = JsonConvert.SerializeObject(putObject);
                    Console.WriteLine("Serialized object: " + putObject + " to: " + json);
                    var httpContent = new ByteArrayContent(Encoding.UTF8.GetBytes(json));
                    var headers = httpContent.Headers;
                    headers.Add("content-type", "application/json");

                    foreach (var header in headers)
                    {
                        Console.WriteLine("Request contains header [" + header.Key + "] with value: [" + header.Value + "].");
                    }
                    var response = await httpClient.PutAsync(server.WEBSERVER_FULL_URL + path, httpContent);
                    Console.WriteLine("Server responded with status message: " + response.StatusCode);
                    return response;
                }
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            catch (HttpRequestException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            return null;
        }
    }
}
