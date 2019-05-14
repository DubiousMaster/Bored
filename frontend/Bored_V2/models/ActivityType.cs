using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Bored_V2.models
{
    internal sealed class ActivityType : Entity
    {
        private string name;

        public string Name
        {
            get
            {
                return name;
            }
        }

        public ActivityType(string name)
        {
            this.name = name;
        }
    }
}
