# Networking In-Depth Analysis

## Concise Important Parts Written

Refer pptx/book of chapter along with it, to understand in detail. Networking is huge in scope try to limit it & focus
on revisions.
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

  ```
  7.Application : Provide Services to User.
  6.Presentation : Translation, Compression, Encryption.
  5.Session : Dialog control & Session sync. 
  
  4.Transport : Segments are transported. Message dilevery
                for processes.
  
  3.Network : Header added. Responsible for Source
              to Destination packet transmission.
              Also, logical to physical address conversion
              , data sent only reaches till this layer if not
              source.
  
  2.Data link: Headed & tail added. Responsible
               for movement of frames.
  1.Physical : Individual bits movements from one
               hop to another. header is also added.
  ```

---
Note :
* Don't refer multiple sources for this topics. Vast topicsd, Study Smart.
---
References : 
* Data Communication and Networking -Forouzan
