using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace Bored_V2.http
{
    internal sealed class BoredServer : Server
    {
        public BoredServer() : base("http://localhost", ":8080", "/bored_v2/rest")
        {
        }
    }
}
