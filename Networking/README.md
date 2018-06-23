# Networking In-Depth Analysis

## Concise Important Parts Written

Refer pptx/book of chapter along with it, to understand in detail. Networking is huge in scope try to limit it & focus on revisions.

---
### Chapter 1 : Inrtoduction

* Dataflows : Simplex, Half-Duplex, Full-Duplex
* Types Of Connection : P-2-P, Multipoint
* Topology Categories : Mesh, Start, Bus, Ring, Hybrid. Advantages/Disadvantages over one-another is important.
* NAP : public network exhange facility where ISPs are connected in peering arrangement.
* Hierarchy of ISPs : National ISPs > Regional ISPs > ISPs. National ISPs connected via NAPs.

Additional Important Interview Topic : Designing Own Protocol Basics  

* Choice of protocol either to be text-based or bit-based protocols.
* Text-Based Protocols : HTTP is an example of it. Easy to write & debug, not affected by endianness.
Can't parse in one go, less precise, can't verify validation, different encoding mechanisms causes problems.
* Binay Protocols solve the endianness( big-stores MSB first, small-LSB first) problem with mixed number systems.
Magic number('MM' & 'll') are added as an header two bytes of known values to identify the type.
* Idenitfy the needs of a protocol. Add header, then name of organization + protocol name, then data flows( own
headers to detect corruption). Send this data through the server in byte/bit wise stream with bit manipulation.  
---
### Chapter 2 : Network Models

* ISO standart for network communication is OSI( Open System Interconnection) Model.
* Peer-to-peer (P2P) computing or networking is a distributed application architecture that partitions tasks or workloads between peers.
Peers are equally privileged in the application. P2P network of nodes are formed. Rules & regulations defined for such communications are called P2P protocols.
* TCP/IP has four layers : host-to-network, internet, transport & application layers. In-reference to OSI model
there are physical, data link, network, transport & application.

```
7.Application : Provide Services to User.                       |    Examples : SMTP, FTP, HTTP, DNS, SNMP
6.Presentation : Translation, Compression, Encryption.          |               , TELNET
5.Session : Dialog control & Session sync.                      |    4.(5.6.7.) Application Layer for TCP
                                                                |
4.Transport : Segments are transported. Message dilevery        |    Examples : SCTP, UDP, TCP
              for processes.                                    |    3.(4.) Transport Layer
                                                                |
3.Network : Header added. Responsible for Source              TCP/IP  
            to Destination packet transmission.              Protocol
            Also, logical to physical address conversion        |
            , data sent only reaches till this layer if not     |    Components : ICMP, IGMP, RARP, ARP
            source.                                             |    2.(3.) Network Layer
                                                                |
2.Data link: Headed & tail added. Responsible                   |
             for movement of frames.                            |    For Physical Layer 
1.Physical : Individual bits movements from one                 |    underlying networks define protocols.
             hop to another. header is also added.              |
  ```
* Summarized OSI vs TCP/IP protocol : OSI model is network independent protocol vs TCP/IP is based on standard
practical protocols over net. OSI model guarantee packet delivery, where as TCP/IP don't still trustable. More
detailed structure :
  * OSI (connection oreinted Transport Layer) v/s TCP/IP (Both, ConnectionLess also there).
  * OSI (network layer, connection + connectionless) v/s TCP/IP(Only connectionless).
  * OSI strictly define services, interfaces & protocols where as TCP/IP don't.

* Addressing At four levels physical(data link L.+  physical L.), logical(network L.), port(transport L.) & specific(Application L.).
  * Physical Address : 48-bit(6-byte) physical address written as 12 hexadecimal digits. Physical address for a packet changes hop-to-hop but logical address remains same.
  * Logical Addresses : Ipv4 32-bit, dotted decimal notation for 4-parts of 8-bit numbers. Ipv6 128-bit, 8 parts of 16 bit numbers.
  * Port Address : 16-bit port number represented as single number. Port number also remains same.
  * Application Specific Address : emails & urls are example.

---
Note :
* Don't refer multiple sources for these topics. Vast resources available, Study Smart to give equivalent time to other easy subjects.

---
References : 
* Data Communication and Networking -Forouzan
