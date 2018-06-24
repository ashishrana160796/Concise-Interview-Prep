# Networking In-Depth Analysis

## Concise Important Parts Written

Refer pptx/book of chapter along with it, to understand in detail. Networking is huge in scope try to limit it & focus on revisions.

---
### Chapter 1 : Introduction

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

### Chapter 25 : DNS

* DNS servers return the IP address of the Web server associated with that name.
* Unambigous namespace is constructed with complete control over binding name to IP addresses. Domain Name Space was designed in an inverted tree form 0( root ) to level 127. FQ( Fully qualified )DN terminates with null string where as PQ( Partially Qualified )DN.
* Distribution of DNS information to be stored. 
  * Primary server loads all information from disk. Secondary server loads all information from primary server, & is called zone transfer.
* A DNS zone is any distinct, contiguous portion of the domain name space in the Domain Name System (DNS) for which administrative responsibility has been delegated to a single manager.  
* DNS protocol is divided into three different sections : generic, country & inverse domain. 
  * generic : edu, com, biz, coop, int etc.
  * country : us, pk, uk etc.
  * The inverse domain finds a domain name for a given IP address. This is called address-to-name resolution.
* Mapping a name to an address or an address to a name is called name-address resolution. Two types recursive & iterative in nature.
* Query & Response, DNS messages : Query message consists of header & question records. Response messages consist of header, question records, answer records, authoritative records & additional records.
* Header identification( questions, authoritative records ) & flags( number of answer records & additional records ).
* A registrar, a commercial entity accredited by ICANN( International Corporation for Assigned Names & Numbers ) can add new domain into DNS.
* DDNS dynamically updates DNS master file. Binding b/w name & address is to be determined request is sent by
DHCP( Dynamic Host Configuration Protocol, dynamically assigns an IP address ) to primary DNS server. Primary server updates the zones & secondary server are notified actively or passively.
* DNS can use UDP(<512 bytes) or TCP with port number 53.
---
### Chapter 27 : WWW & HTTP

* www : is a service of client/server which a client with browser can access anywhere with server. Service is distributed over many locations called site.
* Url's structure : Protocol :// Host : Port / Path
* Port Numbers : HTTP(80), HTTPS(443), SMTP(25), DNS(53)
* Web documents can be classified into static, dynamic, active base on when the contents of documents are determined.
  * Static html tags are coded into html documents.
  * Dynamic documents are sometimes referred to as server-site dynamic documents. Operational program sits on server which attaches dynamic scripts inside html for customizations.
  * Active documents are sometimes referred to as client-site dynamic documents. These can be in the form of applets returned by server or JS scripts being requested.
* HTTP functions as a combination of FTP & SMTP. HTTP uses services of TCP at port number 80.

| Request Message | Response Message |
| --------------- | --------------- |
| Request Line | Status line |
| Headers | Headers |
| Blank Line | Blank Line |
| Body | Body |

* Structure of Request & Status line as follow :
```
REQUEST LINE
Request Type (Space) URL (Space) HTTP version

STATUS LINE
HTTP version (Space) Status Code (Space) Status phrase
```

* Different method in Http including GET & POST in detail.

| Method Name | Action |
| --- | --- |
| GET | Request document from server. |
| HEAD | Request information about the document. |
| POST | Sends information from client to server. |
| PUT | Sends document from server to client. |
| TRACE | Echoes the incoming request. |
| CONNECT | Reserved. |
| OPTION | Inquires about available options. |

* Important HTTP status codes : Informations(100s), Success(200s), Redirection(300s), Client Error(400s), Server Errors(500s)  

| Code | Phrase | Description |
| --- | --- | --- |
| 100 | Continue | Initial request received, client continue with its request. |
| 101 | Switching | Server complying with client to switch protocols in upgrade header. |
| 200 | OK | request is successful. |
| 201 | Created | new url created. |
| 202 | Accepted | Request accepted, but not acted upon. |
| 204 | No content | No content in body. |
| 301 | Moved permanently | url moved by server permanently. |
| 302 | Moved temporarily | The url is moved temporarily. |
| 304 | Not modified | Document has not been modified. |
| 400 | Bad Request | Syntax error. |
| 401 | Unauthorized | lacks authorization. |
| 403 | Forbidden | Service denied. |
| 404 | Not Found | document not found. |
| 405 | Method not allowed | Method not supported in url. |
| 406 | Not acceptable | format request not acceptable. |
| 500 | Internal Server Error | error like crash. |
| 501 | Not implemented | action cannot be performed. |
| 503 | Service Unavailable | Not available for now. |

* Header format( Header name: (Space) Header value ) : Types of headers General, Request, Response, Entity. 
```
General :   Cache-control, Connection, Date, MIME, Upgrade.
Request : Accept - ( _ , charset, encoding, language), Aurthorization, From, Host, If- (modified-since, match, non-match, range, unmodified-since)
Response : Accept range, age, public, Retry-after, Server
Entity : Allow, Content -(encoding, language, length, range, type), 
```

* HTTP version 1.1 specifies a persistent connection by default.

---
### Chapter 32 : Security On Internet

* Structure Of Security Protocol
```
Header Of Security Protocol
--------------------------- |
Payload(from IP, TCP, SMTP) |
--------------------------- | Encrypted
            MAC             |
--------------------------- |
Trailer Of Security Protocol 
```

* IPSec : IPSecurity a protocol designed by IETF for packet security at network level.
  * Two modes of operation : Transport Mode it only protects transport layer payload not ip-header. But, in tunnel mode it protects both Payload+IP-header. Attaches header & trailer of its own.
  * In Transport Mode IPSec layer is b/w transport & network layer. But, in tunnel mode it is in between only Network layer.  
  * Authenticiation header(4-byte) in transport mode provides source of authenticiation, data integrity, but not privacy.
  *  ESP(Encapsulationg security header) header & trailer provides source authenticiation, data integrity, & privacy. It has advantage of providing Confidentiality over AH. It provides encryption of DES address but not in AH.
  *  IKE(Internet Key Exchange) provides SAs( Security Associations : agreement on how they will use security services) for IPSec. 
    * ISAKMP( Internet Security Association & Key Management Protocol) : Oakley & SKEME  

| Prefix | Range | Total |
| ------------- | ------------- | ------------- |
| 10/8 | 10.0.0.0 to 10.255.255.255 | 2^24 |
| 172.16/12 | 172.16.0.0 to 172.31.255.255 | 2^20 |
| 192.168/16 | 192.168.0.0 to 192.168.255.255 | 2^16 |

#### Important Topics

* SSL(Secure Socket Layer) & TLS(Transport Layer Security). Later is IETF version of former. It works at transport layer.
```
Cipher suite for SSL : SSL_( Key Exchange Algorithm )_WITH_( Encryption Algorithm )_( Hash Algorithm )

KEA :   NULL, RSA( cryptosystem ), DH_anon, DHE_RSA, DHE_DSS, DH_RSA, DH_DSS, FORTEZZA_DMS
EA : NULL, RC4_128, IDEA_CBC, DES_CBC, 3DES_EDE_CBC, FORTEZZA_CBC
HA : MD5( 128-bit hash value ), SHA-1( 160-bit hash value )
```
* Client & Server have six different cryptographic secrets. Authenticiation, encryption & Initiation vector for client & server.
* Four SSL protocols Hanshake, ChangeCipherProtocol, Alert, Record protocol.
```
Handshake protocol : Security establish -> Server auth. & key exchange -> Client auth. & key exchange -> Finalize
```

```
Record Protocol : SSL payload is encrypted except header. Compression & Encryption process is involved.

```

* PGP( Pretty Good Privacy) : It is created to give authenciated & confidential emails. Operates at application layer. Sender will include identifier of algorithms in message as well as values of keys.   
  * Security at application layer.
  * Here, there can be multiple paths from fully or partially trusted authorities to any subject.

```
PGP Message = Header + [[Email Message][Hash Algo + Public key Algo( for Session key encryption)+ Private key Of Sender(+ Encrypted Digest) ]] + [Public Key Algo( encrypt digest ) + Symmetric-key algorithm Identification]
```

* Firewalls : A firewall is a device installed between the internal network of an organization and the rest of the Internet. It is designed to forward some packets and filter (not forward) others.
  * A packet-filter firewall filters at the network or transport layer.
  * A proxy firewall filters at the application layer. From HTTP prcoy to HTTP Server accepted packets are floated.
  
---
Note :
* Don't refer multiple sources for these topics. Vast resources available, Study Smart to give equivalent time to other easy subjects.

---
References : 
* Data Communication and Networking -Forouzan
