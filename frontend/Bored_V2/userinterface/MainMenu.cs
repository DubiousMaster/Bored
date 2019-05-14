using Bored_V2.http;
using Bored_V2.http.mappers;
using Bored_V2.http.requests;
using Bored_V2.models;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace Bored_V2.userinterface
{
    public partial class MainMenu : Form
    {
        private Server server;

        public MainMenu()
        {
            this.server = new BoredServer();
            InitializeComponent();
            //RunTests();
        }

        private async void RunTests()
        {
            Console.WriteLine("Running tests.");
            var test = new TestRequest(server);
            await test.TestGetConnectionAsync();
            await test.TestPostConnectionAsync();
            await test.TestPutConnectionAsync();
            await test.TestAdvancedGetConnectionAsync();
        }

        private void FillPanel(List<Activity> activities)
        {
            lboxActivities.Items.Clear();
            foreach(var activity in activities)
            {
                lboxActivities.Items.Add(activity);
            }
        }

        private async void BtnConfirmAccessibility_Click(object sender, EventArgs e)
        {
            var request = new ActivityRequest(server);
            var lowerbound = nudLowerboundAccessibility.Value;
            var higherbound = nudUpperboundAccessibility.Value;
            var activityMappers = await request.GetActivitiesByAccessibilityAsync(lowerbound: lowerbound, higherbound: higherbound);
            FillPanel(ToActivity(activityMappers));
            
        }

        private async void BtnConfirmParticipants_Click(object sender, EventArgs e)
        {
            var request = new ActivityRequest(server);
            var lowerbound = nudLowerboundParticipants.Value;
            var higherbound = nudUpperboundParticipants.Value;
            var activityMappers = await request.GetActivitiesByParticipants(lowerbound: (int)lowerbound, higherbound: (int)higherbound);
            FillPanel(ToActivity(activityMappers));
        }

        private async void BtnConfirmPrice_Click(object sender, EventArgs e)
        {
            var request = new ActivityRequest(server);
            var lowerbound = nudLowerboundPrice.Value;
            var higherbound = nudUpperboundPrice.Value;
            var activityMappers = await request.GetActivitiesByPrice(lowerbound: lowerbound, higherbound: higherbound);
            FillPanel(ToActivity(activityMappers));
        }

        private List<Activity> ToActivity(List<ActivityMapper> activityMappers)
        {
            var activities = new List<Activity>();
            try
            {
                foreach (var mapper in activityMappers)
                {
                    activities.Add((Activity)mapper.ToEntity);
                }
            }
            catch(NullReferenceException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            return activities;
        }
    }
}
