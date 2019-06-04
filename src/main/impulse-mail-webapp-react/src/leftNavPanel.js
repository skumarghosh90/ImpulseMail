import React from 'react';

function LeftNavPanel(props) {
    return (
        <div style={{backgroundColor : '#0575ff', paddingTop: '10px', paddingLeft: '10px'}}>
            <div><h5><a href="#" style={{color: 'white'}}>Inbox <strong>(4)</strong></a></h5></div><br/>
            <div><h5><a href="#" style={{color: 'white'}}>Sent Items </a></h5></div><br/>
            <div><h5><a href="#" style={{color: 'white'}}>Search Results</a></h5></div><br/>
            <div><h5><a href="#" style={{color: 'white'}}>Settings </a></h5></div><br/>
        </div>
    );
}

export default LeftNavPanel;