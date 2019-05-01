using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Core.core.models
{
    class Activity
    {
        private int id;
        private string name;
        private double accessibility;
        private int type;
        private int participants;
        private double price;
        private string link;
        private int activityKey;

        public Activity(int id, string name, double accessibility, int type, int participants, double price, string link, int activityKey)
        {
            this.id = id;
            this.name = name;
            this.accessibility = accessibility;
            this.type = type;
            this.participants = participants;
            this.price = price;
            this.link = link;
            this.activityKey = activityKey;
        }
    }
}
