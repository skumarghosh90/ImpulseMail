import React from 'react';
import { BrowserRouter, Link} from 'react-router-dom';

class TopNavbar extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        collapse: false,
        isWideEnough: false,
        searchPhrase: props.state.searchedPhrase
    };
    this.onClick = this.onClick.bind(this);
    this.onInputChange = this.onInputChange.bind(this);
    this.onSubmitSearch = this.onSubmitSearch.bind(this);
  }

onClick(){
    this.setState({
      collapse: !this.state.collapse
  });
}

onInputChange(event) {
    this.setState({
        [event.target.name] : event.target.value
    });    
}

onSubmitSearch(event) {
    event.preventDefault();
    console.log('search messgaes having phrase: ' +this.state.searchPhrase);
    this.props.handleSearchResult([{sender: 'sourav', receiver: 'vishakha', message: 'hi'},{sender: 'vishakha', receiver: 'sourav', message: 'zzzz'}]);
}


render() {
    return (
        <BrowserRouter>
            
                <div className="row" style={{backgroundColor : '#0575ff', paddingTop: '10px'}}>
                    <div className="col-md-3">
                        <h2 style={{color : 'white'}}><i className="fa fa-home fa-lg" aria-hidden="true"> </i>&nbsp;Impulse Mail</h2>
                    </div>
                    <div className="col-md-4">
                        <form className="navbar-form navbar-left" onSubmit={this.onSubmitSearch}>
                            <input name="searchPhrase" className="form-control" type="text" value={this.setState.searchPhrase} 
                                                    placeholder="Search" aria-label="Search" onChange={this.onInputChange}/>
                        </form>
                    </div>
                    <div className="col-md-1">
                        <button type="button" onClick={this.onSubmitSearch} className="btn btn-success"><i className="fa fa-search fa-lg" aria-hidden="true"/>Search</button>
                    </div>
                    <div className="col-md-3" style={{textAlign: 'right'}}>
                        <h4><Link style={{color: 'white'}} to="/profile">{this.props.state.loggedInUser.displayName}</Link></h4>
                    </div>
                    <div className="col-md-1">
                        <button type="button" className="btn btn-danger" onClick={this.props.onLogout}>Logout</button>
                    </div>
                </div>
            
        </BrowserRouter>
    );
  }
}

export default TopNavbar;