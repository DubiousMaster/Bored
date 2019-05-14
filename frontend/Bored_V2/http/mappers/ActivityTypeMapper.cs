using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using Bored_V2.models;

namespace Bored_V2.http.mappers
{
    internal sealed class ActivityTypeMapper : Mapper
    {
        public string Name { get; set; }

        public ActivityTypeMapper()
        {
        }

        public ActivityTypeMapper(string name)
        {
            Name = name;
        }

        public override Entity ToEntity => new ActivityType(name: Name);
    }
}
