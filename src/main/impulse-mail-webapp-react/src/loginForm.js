import React, {useState} from 'react';
import { BrowserRouter} from 'react-router-dom';


function LoginForm(props) {

    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const onSubmitLogin = (event) => {
        event.preventDefault();
        let tempUser = {username: userName, displayName: ' Sourav Ghosh', authToken: 'abcd1234'};
        props.handleLogin(tempUser);
    }

    return(
        <BrowserRouter>
            <center>
            <div className="row" style={{backgroundColor : '#003e66', height: '95vh', width: '99%'}}>
                <div className="col-md-4"/>
                <div className="col-md-4" style={{marginTop: '10%'}}>
                    <form onSubmit={onSubmitLogin}>
                        <center><h1 style={{contentAlign: 'center', color: 'white'}}>Impulse Mail</h1></center><br/>
                        <input name="userName" className="form-control" type="text" value={userName} 
                                    placeholder="username" onChange={(event) => setUserName(event.target.value)}/> <br/>

                        <input name="password" className="form-control" type="password" value={password} 
                                    placeholder="password" onChange={(event) => setPassword(event.target.value)}/> <br/>
                        <div className="row">
                            <div className="col-md-3"/>
                            <div className="col-md-3">
                                <a href="#" onClick={onSubmitLogin} className="btn btn-success">Login</a>
                            </div>
                            <div className="col-md-4">
                                <a href="#" onClick={onSubmitLogin} className="btn btn-success">Reset Password</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            </center>
        </BrowserRouter>
    );
};

export default LoginForm;