using Bored_V2.models;
using System.Runtime.Serialization;

namespace Bored_V2.http.mappers
{
    internal abstract class Mapper
    {
        protected Mapper()
        {
        }

        public abstract Entity ToEntity { get; }
    }
}
