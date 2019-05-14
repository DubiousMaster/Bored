using Newtonsoft.Json;
using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Bored_V2.http.requests
{
    internal class TestRequest : Request
    {
        public TestRequest(Server server) : base(server)
        {
        }

        public async Task<HttpResponseMessage> TestGetConnectionAsync()
        {
            var response = await GetRequest("/test");
            return response;
        }

        public async Task<HttpResponseMessage> TestPostConnectionAsync()
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var strings = new string[] { "Clientside Test", "Clearly a success!", "\"Apples\", \"Pears, Bread, Eggs" };
                    var response = await PostRequest("/test", strings);
                    return response;
                }
            } catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }

        public async Task<HttpResponseMessage> TestPutConnectionAsync()
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var strings = new string[] { "Clientside Test", "Clearly another success!", "I accidentally put my grocery shoppinglist here." };
                    var response = await PutRequest("/test", strings);
                    return response;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }

        public async Task<HttpResponseMessage> TestAdvancedGetConnectionAsync()
        {
            try
            {
                using (var httpClient = CreateClient())
                {
                    var response = await GetRequest("/test/advanced");
                    var result = response.Content.ReadAsByteArrayAsync().Result;
                    var json = Encoding.UTF8.GetString(result);
                    var testResult = JsonConvert.DeserializeObject<string>(json);
                    Console.WriteLine(testResult);
                    return response;
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            return null;
        }
    }
}
