package com.github.plexpt.iyuu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * qb  返回信息
 *
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 16:12
 */
@NoArgsConstructor
@Data
public class QBittorrentInfo {

    /**
     * Property	Type	Description
     * added_on	integer	Time (Unix Epoch) when the torrent was added to the client
     * amount_left	integer	Amount of data left to download (bytes)
     * auto_tmm	bool	Whether this torrent is managed by Automatic Torrent Management
     * availability	float	Percentage of file pieces currently available
     * category	string	Category of the torrent
     * completed	integer	Amount of transfer data completed (bytes)
     * completion_on	integer	Time (Unix Epoch) when the torrent completed
     * dl_limit	integer	Torrent download speed limit (bytes/s). -1 if ulimited.
     * dlspeed	integer	Torrent download speed (bytes/s)
     * downloaded	integer	Amount of data downloaded
     * downloaded_session	integer	Amount of data downloaded this session
     * eta	integer	Torrent ETA (seconds)
     * f_l_piece_prio	bool	True if first last piece are prioritized
     * force_start	bool	True if force start is enabled for this torrent
     * hash	string	Torrent hash
     * last_activity	integer	Last time (Unix Epoch) when a chunk was downloaded/uploaded
     * magnet_uri	string	Magnet URI corresponding to this torrent
     * max_ratio	float	Maximum share ratio until torrent is stopped from seeding/uploading
     * max_seeding_time	integer	Maximum seeding time (seconds) until torrent is stopped from seeding
     * name	string	Torrent name
     * num_complete	integer	Number of seeds in the swarm
     * num_incomplete	integer	Number of leechers in the swarm
     * num_leechs	integer	Number of leechers connected to
     * num_seeds	integer	Number of seeds connected to
     * priority	integer	Torrent priority. Returns -1 if queuing is disabled or torrent is in seed mode
     * progress	float	Torrent progress (percentage/100)
     * ratio	float	Torrent share ratio. Max ratio value: 9999.
     * ratio_limit	float	TODO (what is different from max_ratio?)
     * save_path	string	Path where this torrent's data is stored
     * seeding_time_limit	integer	TODO (what is different from max_seeding_time?)
     * seen_complete	integer	Time (Unix Epoch) when this torrent was last seen complete
     * seq_dl	bool	True if sequential download is enabled
     * size	integer	Total size (bytes) of files selected for download
     * state	string	Torrent state. See table here below for the possible values
     * super_seeding	bool	True if super seeding is enabled
     * tags	string	Comma-concatenated tag list of the torrent
     * time_active	integer	Total active time (seconds)
     * total_size	integer	Total size (bytes) of all file in this torrent (including unselected ones)
     * tracker	string	The first tracker with working status. Returns empty string if no tracker is working.
     * up_limit	integer	Torrent upload speed limit (bytes/s). -1 if ulimited.
     * uploaded	integer	Amount of data uploaded
     * uploaded_session	integer	Amount of data uploaded this session
     * upspeed	integer	Torrent upload speed (bytes/s)
     * Possible values of state:
     *
     * Value	Description
     * error	Some error occurred, applies to paused torrents
     * missingFiles	Torrent data files is missing
     * uploading	Torrent is being seeded and data is being transferred
     * pausedUP	Torrent is paused and has finished downloading
     * queuedUP	Queuing is enabled and torrent is queued for upload
     * stalledUP	Torrent is being seeded, but no connection were made
     * checkingUP	Torrent has finished downloading and is being checked
     * forcedUP	Torrent is forced to uploading and ignore queue limit
     * allocating	Torrent is allocating disk space for download
     * downloading	Torrent is being downloaded and data is being transferred
     * metaDL	Torrent has just started downloading and is fetching metadata
     * pausedDL	Torrent is paused and has NOT finished downloading
     * queuedDL	Queuing is enabled and torrent is queued for download
     * stalledDL	Torrent is being downloaded, but no connection were made
     * checkingDL	Same as checkingUP, but torrent has NOT finished downloading
     * forceDL	Torrent is forced to downloading to ignore queue limit
     * checkingResumeData	Checking resume data on qBt startup
     * moving	Torrent is moving to another location
     * unknown	Unknown status
     *
     * ex：
     * added_on : 1588784706
     * amount_left : 0
     * auto_tmm : false
     * availability : -1
     * category :
     * completed : 2291595938
     * completion_on : 1588788399
     * dl_limit : 0
     * dlspeed : 0
     * downloaded : 0
     * downloaded_session : 0
     * eta : 8640000
     * f_l_piece_prio : false
     * force_start : false
     * hash : 4885ec2f8b5704
     * last_activity : 1591054334
     * magnet_uri : magnet:?xt=urn:btih:4885ec2
     * max_ratio : -1
     * max_seeding_time : -1
     * name : 漫威
     * num_complete : 12
     * num_incomplete : 0
     * num_leechs : 0
     * num_seeds : 0
     * priority : 0
     * progress : 1
     * ratio : 0.01751244725761946
     * ratio_limit : -2
     * save_path : L:\
     * seeding_time_limit : -2
     * seen_complete : -28800
     * seq_dl : false
     * size : 2291595938
     * state : stalledUP
     * super_seeding : false
     * tags :
     * time_active : 2869071
     * total_size : 2291595938
     * tracker : https://pt
     * up_limit : 113664
     * uploaded : 40131453
     * uploaded_session : 0
     * upspeed : 0
     */

    private long added_on;
    private long amount_left;
    private boolean auto_tmm;
    private long availability;
    private String category;
    private long completed;
    private long completion_on;
    private long dl_limit;
    private long dlspeed;
    private long downloaded;
    private long downloaded_session;
    private long eta;
    private boolean f_l_piece_prio;
    private boolean force_start;
    private String hash;
    private long last_activity;
    private String magnet_uri;
    private long max_ratio;
    private long max_seeding_time;
    private String name;
    private long num_complete;
    private long num_incomplete;
    private long num_leechs;
    private long num_seeds;
    private long priority;
    private long progress;
    private double ratio;
    private long ratio_limit;
    private String save_path;
    private long seeding_time_limit;
    private long seen_complete;
    private boolean seq_dl;
    private long size;
    private String state;
    private boolean super_seeding;
    private String tags;
    private long time_active;
    private long total_size;
    private String tracker;
    private long up_limit;
    private long uploaded;
    private long uploaded_session;
    private long upspeed;
}
