using Core.core.http;
using Core.core.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Core.core.userinterface
{
    public partial class DisplayData : Form
    {
        public DisplayData()
        {
            InitializeComponent();

            var webResponse = new ServerCommunicator().GetRequest("/activities");
            var serializer = new DataContractJsonSerializer(new List<Activity>().GetType());
            var deserializedActivity = serializer.ReadObject(webResponse.GetResponseStream()) as List<Activity>;
            webResponse.Close();

            foreach (var a in deserializedActivity)
            {
                Console.WriteLine(a.name);
            }

            this.lbActivities.Items.AddRange(deserializedActivity.ToArray());
        }

        private void BtnAdvancedSearch_Click(object sender, EventArgs e)
        {

        }
    }
}
