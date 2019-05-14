using Bored_V2.http.mappers;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;

namespace Bored_V2.http.requests
{
    internal sealed class ActivityRequest : Request
    {
        private readonly string URL_EXTENSION;

        public ActivityRequest(Server server) : base(server)
        {
            URL_EXTENSION = "/activities";
        }

        public async Task<List<ActivityMapper>> GetActivities()
        {
            var response = await GetRequest(URL_EXTENSION);
            return JsonConvert.DeserializeObject<List<ActivityMapper>>(GetJsonResponse(response));
        }

        public async Task<List<ActivityMapper>> GetActivitiesByAccessibilityAsync(decimal lowerbound, decimal higherbound)
        {
            var response = await GetRequest(URL_EXTENSION + "/accessibility/" + lowerbound + "/" + higherbound);
            return JsonConvert.DeserializeObject<List<ActivityMapper>>(GetJsonResponse(response));

        }

        public async Task<ActivityMapper> GetActivityByKey(string key)
        {
            var response = await GetRequest(URL_EXTENSION + "/key/" + key);
            return JsonConvert.DeserializeObject<ActivityMapper>(GetJsonResponse(response));
        }

        public async Task<ActivityMapper> GetActivityByName(string name)
        {
            var response = await GetRequest(URL_EXTENSION + "/name/" + name);
            return JsonConvert.DeserializeObject<ActivityMapper>(GetJsonResponse(response));
        }

        public async Task<List<ActivityMapper>> GetActivitiesByParticipants(int lowerbound, int higherbound)
        {
            var response = await GetRequest(URL_EXTENSION + "/participants/" + lowerbound + "/" + higherbound);
            return JsonConvert.DeserializeObject<List<ActivityMapper>>(GetJsonResponse(response));
        }

        public async Task<List<ActivityMapper>> GetActivitiesByPrice(decimal lowerbound, decimal higherbound)
        {
            var response = await GetRequest(URL_EXTENSION + "/price/" + lowerbound + "/" + higherbound);
            return JsonConvert.DeserializeObject<List<ActivityMapper>>(GetJsonResponse(response));
        }

        public async Task<ActivityMapper> PostActivity(ActivityMapper activityMapper)
        {
            var response = await PostRequest(URL_EXTENSION + "/new", activityMapper);
            return JsonConvert.DeserializeObject<ActivityMapper>(GetJsonResponse(response));
        }

        public async Task<ActivityMapper> PutActivity(ActivityMapper activityMapper)
        {
            var response = await PutRequest(URL_EXTENSION + "/update", activityMapper);
            return JsonConvert.DeserializeObject<ActivityMapper>(GetJsonResponse(response));
        }
    }
}
